let running = false


function draw(boids) {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    for (const b of boids) {
        ctx.beginPath();
        ctx.arc(b.x, b.y, 3, 0, 2 * Math.PI);
        ctx.fillStyle = 'white';
        ctx.fill();
    }
}

async function initBoids(count) {
    if (running === false) {

        //makes backend create boid array
        fetch('/api/boids/init', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({count: count})
        });
        await res.json();
        //store result in local boids variable
//draw new boids every 50ms
        setInterval(async () => {
            const res = await fetch('/api/boids/step', {method: 'POST'});
            const boids = await res.json();
            draw(boids);
        }, 50);

        running = true;
    }
}

//call init when button is pressed
document.getElementById('initButton').addEventListener('click', () => {
    const count = parseInt(document.getElementById('count').value);
    initBoids(count);
});