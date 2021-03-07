import React, {useState} from 'react';

function Calculator() {
    const [amount, setAmount] = useState();
    const [type, setType] = useState('penguin');
    const [mode, setMode] = useState('single');
    const [price, setPrice] = useState();

    const handleAmountChanged = e => {
        setAmount(e.target.value);
    };

    const handleTypeChanged = e => {
        setType(e.target.value);
    };

    const handleModeChanged = e => {
        setMode(e.target.value);
    };

    const handleButtonClicked = e => {
        let url;
        let units = parseInt(amount);

        if (type == 'penguin') {
            if(mode == 'carton') {
                units = parseInt(amount) * 20;
            }
            url = 'http://localhost:8080/penguinEars';
        } else {
            if(mode == 'carton') {
                units = parseInt(amount) * 5;
            }
            url = 'http://localhost:8080/horseShoe';
        }
        console.log(units);
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: units
        };
        fetch(url, requestOptions)
            .then(data => data.json())
            .then(items => {
                setPrice(items)
            })
    };

    return  (
        <div>
            <select
                value={type}
                onChange={handleTypeChanged}
            >
                <option value="penguin">Penguin Ears</option>
                <option value="horse">Horse Shoe</option>
            </select><br/>
            <select
                value={mode}
                onChange={handleModeChanged}
            >
                <option value="single">Single units</option>
                <option value="carton">Carton</option>
            </select><br/>
            <input type="text" value={amount} onChange={handleAmountChanged}/>
            <button onClick={handleButtonClicked}>
                Submit
            </button>
            <div>
                <input type="text" value={price}/>
            </div>
        </div>
    );
}

export default Calculator;