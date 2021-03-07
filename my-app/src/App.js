import React from "react";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import PenguinTable from "./PenguinTable";
import HorseTable from "./HorseTable";
import Calculator from "./Calculator";

export default function BasicExample() {
    return (
        <Router>
            <div>
                <ul>
                    <li>
                        <Link to="/penguinTable">Penguin Ears Table</Link>
                    </li>
                    <li>
                        <Link to="/horseTable">Horse Shoe Table</Link>
                    </li>
                    <li>
                        <Link to="/calculator">Calculator</Link>
                    </li>
                </ul>

                <hr/>
                <Switch>
                    <Route exact path="/penguinTable">
                        <PenguinTable/>
                    </Route>
                    <Route exact path="/horseTable">
                        <HorseTable/>
                    </Route>
                    <Route exact path="/calculator">
                        <Calculator/>
                    </Route>
                </Switch>
            </div>
        </Router>
    );
}
