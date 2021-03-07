import React, {useEffect, useState} from 'react';
import ReactTable from "react-table";
import "react-table/react-table.css";

function PenguinTable() {
    const [data, setData] = useState([]);

    useEffect(() => {
        let mounted = true;
        const requestOptions = {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: 50
        };
        fetch('http://localhost:8080/penguinEarsList', requestOptions)
            .then(data => data.json())
            .then(items => {
                if (mounted) {
                  setData(items)
                }
            })
        return () => mounted = false;
    }, [])

    // const data = [{
    //     name: 'Ayaan',
    //     age: 26
    // }, {
    //     name: 'Ahana',
    //     age: 22
    // }, {
    //     name: 'Peter',
    //     age: 40
    // }, {
    //     name: 'Virat',
    //     age: 30
    // }, {
    //     name: 'Rohit',
    //     age: 32
    // }, {
    //     name: 'Dhoni',
    //     age: 37
    // }]
    const columns = [{
        Header: 'Order Quantity',
        accessor: 'numOrdered'
    }, {
        Header: 'Total Price',
        accessor: 'price'
    }]
    return (
        <div>
            <ReactTable
                data={data}
                columns={columns}
                defaultPageSize={50}
            />
        </div>
    )
}

export default PenguinTable;