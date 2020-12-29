let React = require('react');
let ReactDOM = require('react-dom');
import { Button, Container, Row, Col, Navbar, Nav, NavDropdown, Form, FormControl, Card } from 'react-bootstrap';
import { BrowserRouter as Router, Switch, Route, Link ,Redirect } from "react-router-dom";
import { Layout } from "./Components/Layout";
import { Protected } from "./Components/Protected";
import { Login } from "./Components/Login";
import StaticContext from "./StaticContext";

const PrivateRoute = ({ isLoggedIn, ...props }) =>
	isLoggedIn
		? <Route {...props} />
		: <Redirect to="/login" />

//  <Route path="/protected" component={Protected} />
export default function App() {


	return (

		<Router>
			<Layout>
				<Switch>
					<Route exact path='/' component={Login} />
					 <PrivateRoute isLoggedIn={ StaticContext.LogedIn } path="/protected" component={Protected} />
                   
					<Route path="/login" component={Login} />
				</Switch>
			</Layout>
		</Router>

	);
}
ReactDOM.render(
	<App />,
	document.getElementById('react')
)