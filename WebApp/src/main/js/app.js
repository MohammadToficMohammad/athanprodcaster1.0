let React = require('react');
let ReactDOM = require('react-dom');
import { Button, Container, Row, Col, Navbar, Nav, NavDropdown, Form, FormControl,Card  } from 'react-bootstrap';




export default function App() {


	return (
		<Container fluid style={{ height: '90vh',  padding:'5' }}>
			<Row style={{ height: '100', paddingBottom:'10px'}}>
				<Col><Navbar bg="light" expand="lg" style={{ height: '100' , boxShadow: '5px 10px 8px #888888'}}>
					<Navbar.Brand href="#home">Athan-Prodcaster</Navbar.Brand>
					<Navbar.Toggle aria-controls="basic-navbar-nav" />
					<Navbar.Collapse id="basic-navbar-nav">
						<Nav className="mr-auto">
							<Nav.Link href="#home">Home</Nav.Link>
							<Nav.Link href="#link">Link</Nav.Link>
							<NavDropdown title="Dropdown" id="basic-nav-dropdown">
								<NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
								<NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
								<NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
								<NavDropdown.Divider />
								<NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
							</NavDropdown>
						</Nav>
						<Form inline>
							<FormControl type="text" placeholder="Search" className="mr-sm-2" />
							<Button variant="outline-success">Search</Button>
						</Form>
					</Navbar.Collapse>
				</Navbar>
				</Col>
			</Row>
			<Row style={{ height: '88%' , marginTop:'10px!important' ,paddingBottom:'10px'}}>
				<Col>
				
					<Card style={{    marginTop:'10px!important', height:'100%' , boxShadow: '5px 10px 8px #888888'}}>
						<Card.Body>This is some text within a card body.</Card.Body>
					</Card>
				</Col>
				
			</Row>
			<Row style={{ height: '100' ,marginTop:'10px!important' }}>
				<Col>
				
					<Card bg="light" style={{    marginTop:'10px!important', height:'100%' , boxShadow: '5px 10px 8px #888888'}}>
						<Card.Body>Athan-Prodcaster @2020  </Card.Body>
					</Card>
				</Col>
			</Row>
		</Container>
	);
}
ReactDOM.render(
	<App />,
	document.getElementById('react')
)