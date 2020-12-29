import React, { useState, Component } from 'react';
import { Button, Container, Row, Col, Navbar, Nav, NavDropdown, Form, FormControl, Card } from 'react-bootstrap';
import StaticContext from "../StaticContext";


export class Login extends Component {
	// static displayName = Layout.name;


	constructor(props) {
		super(props);
		this.state =
		{
			email: '',
			password: '',
			message: 'Welcome',
			error: null,
			isLoaded: false,
		};

	}
	handleChange = (keyName, e) => { this.setState({ [keyName]: e.target.value }); }


submitHandler = (event) => {
    event.preventDefault();
 
    fetch(StaticContext.baseUrl + "/authproxy/test/", {
      method: 'GET'
    })
      .then(res => res.text())
      .then(
        (result) => {
          this.setState({ message: result, })
          //alert(result)
        },
        (error) => {
          // alert(error)
          this.setState({ message: error, })
        }
      )
  }


	render() {
		return (
			<div>
		<div style={{margin:'30px'}}>
		{this.state.message}
		</div>
			
				<Form>
					<Form.Group controlId="Email">
						<Form.Control type="text" placeholder="Enter Email" onChange={(e) =>
							this.handleChange('email', e)} value={this.state.email} />
					</Form.Group>
					<Form.Group controlId="Password">
						<Form.Control type="text" placeholder="Enter Password" onChange={(e) =>
							this.handleChange('password', e)} value={this.state.password} />
					</Form.Group>

					<Button variant="primary" type="submit" onClick={this.submitHandler}>
						Submit
                    </Button>
				</Form>
			</div>
		);
	}
}


