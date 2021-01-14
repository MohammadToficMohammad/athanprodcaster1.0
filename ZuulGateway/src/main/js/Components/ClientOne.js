import React, { useState,Component } from 'react';
import { Button, Container, Row, Col, Navbar, Nav, NavDropdown, Form, FormControl,Card  } from 'react-bootstrap';
import {Peer} from 'peerjs';



export class ClientOne extends Component {
 // static displayName = Layout.name;
	constructor(props) {
		super(props);

		

	};
	
	 peer=null;
	 conn=null;
	 streamr=null;
	
	 componentDidMount() {
		    setTimeout(() => {
		    	this.peer= new Peer("athanprodcaster_clientone");
		    }, 1000);
		  };
	handleChange = (keyName, e) => { this.setState({ [keyName]: e.target.value }); }
	
	
	

	Connect = (event) => {
	    event.preventDefault();
	    this.conn=peer.connect('athanprodcaster_clienttwo');
	    this.conn.on('open', function(){
	    	this.conn.send('hi!');
		});   
	    
	  }
	
	
	Disconnect = (event) => {
	    event.preventDefault();
	    this.conn.close();
	    this.peer.disconnect();
	    this.peer.destroy();
	    this.StopStream();
	    
	  }
	
	StartStream = (event) => {
	    event.preventDefault();
	    var getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia;
		var md=getUserMedia({video: false, audio: true}, function(stream) {
			this.streamr=stream;
		  var call = this.peer.call('athanprodcaster_clienttwo', stream);
		  call.on('stream', function(remoteStream) {
		    // Show stream in some video/canvas element.
		  });
		}, function(err) {
		  console.log('Failed to get local stream' ,err);
		});
	    
	  }
	
	StopStream = (event) => {
	    event.preventDefault();
	    this.streamr.getTracks().forEach(function(track) {
			  track.stop();
			});

	    
	  }

  render () {
    return (
       <div>
       client one
       <Button variant="primary" type="button" onClick={this.Connect}>
		Connect
       </Button>
		<Button variant="primary" type="button" onClick={this.Disconnect}>
		Disconnect
       </Button>
		<Button variant="primary" type="button" onClick={this.StartStream}>
		Start Stream
       </Button>
		<Button variant="primary" type="button" onClick={this.StopStream}>
		Stop Stream
       </Button>
      </div>
    );
  }
}


