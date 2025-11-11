let running = false
console.log('running start')
let canvas = document.getElementById('boidCanvas')
let ctx = canvas.getContext('2d')
let boids = []
let intervalId = null;


function draw(boids) {
    console.log('drawing')
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    for (const b of boids) {
        angle = Math.atan2(b.vy, b.vx);

        ctx.save()
        ctx.translate(b.x, b.y);
        ctx.rotate(angle);
        ctx.beginPath();
        ctx.moveTo(6, 0)
        ctx.lineTo(-6, 3)
        ctx.lineTo(-6, -3)
        ctx.closePath();
        ctx.fillStyle = 'white';
        ctx.fill();
        ctx.restore();
    }
}

async function initBoids(count) {
    console.log('initBoids');

    if (running === true) {
        clearInterval(intervalId);
        running = false;
    }

        //makes backend create boid array
        const res = await fetch('/api/boids/init', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({count: count})
        });

        boids = await res.json();
        draw(boids);

//draw new boids every 50ms
        intervalId = setInterval(async () => {
            const res = await fetch('/api/boids/step', {method: 'POST'});
            boids = await res.json();
            draw(boids);
        }, 50);

        running = true;

}

//call init when button is pressed
document.getElementById('initButton').addEventListener('click', () => {
    console.log('click');
    const count = parseInt(document.getElementById('boidCount').value);
    initBoids(count).then(r => boids);
});