import React, { useState,Component } from 'react';
import { Button, Container, Row, Col, Navbar, Nav, NavDropdown, Form, FormControl,Card  } from 'react-bootstrap';



export class ClientTwo extends Component {
 // static displayName = Layout.name;
	constructor(props) {
		super(props);

		

	};
	
	
	  peer=null;
	
	 componentDidMount() {
		    setTimeout(() => {
		    	this.peer= new Peer("athanprodcaster_clienttwo");
		    	
		    	this.peer.on('connection', function(conn) {
		    		conn.on('data', function(data){
		    		    // Will print 'hi!'
		    		    console.log(data);
		    		  });
		    		});
		    		
		    	var getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia;
		    	this.peer.on('call', function(call) {
		    	  getUserMedia({video: false, audio: true}, function(stream) {
		    	    call.answer(null); // Answer the call with an A/V stream.
		    	    call.on('stream', function(remoteStream) {
		    	    	const video = document.getElementById('webcam');
		    	        video.autoplay = true;
		    	        video.srcObject = remoteStream;
		    	    });
		    	  }, function(err) {
		    	    console.log('Failed to get local stream' ,err);
		    	  });
		    	});
		    	
		    	
		    }, 1000)
		  }
  render () {
    return (
       <div>
      clienttwo
      </div>
    )
  }
}


