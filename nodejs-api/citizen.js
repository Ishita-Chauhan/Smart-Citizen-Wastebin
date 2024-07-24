const express = require('express');
const bodyParser = require('body-parser');

const app = express();
const port = 3001;

app.use(bodyParser.json());

// In-memory storage
let citizens = [];

app.post('/citizens', (req, res) => {
    const citizen = req.body;
    citizens.push(citizen);
    res.status(201).send(citizen);
})

app.get('/citizens', (req, res) => {
    res.send(citizens);
})

app.get('/citizens/:id', (req, res) => {
       const id = parseInt(req.params.id, 10);
       const citizen = citizens.find(c => c.id === id);
       if (citizen) {
           res.send(citizen);
       } else {
           res.status(404).send({ message: 'Citizen not found' });
       }
})

app.put('/citizens/:id', (req, res) => {
    const id = parseInt(req.params.id, 10);
    const index = citizens.findIndex(c => c.id === id);
    if (index!== -1) {
        citizens[index] = req.body;
        res.send(citizens[index]);
    } else {
        res.status(404).send({ message: 'Citizen not found' });
    }
})

app.delete('/citizens/:id', (req, res) => {
    const id = parseInt(req.params.id, 10);
    const index = citizens.findIndex(c => c.id === id);
    if (index !== -1) {
        const deletedCitizen = citizens.splice(index, 1);
        res.send(deletedCitizen);
    } else {
        res.status(404).send({ message: 'Citizen not found' });
    }
})


app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});