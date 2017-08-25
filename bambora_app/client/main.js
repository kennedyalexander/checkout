import { Template } from 'meteor/templating';
import { ReactiveVar } from 'meteor/reactive-var';
import { HTTP } from 'meteor/http';

import './main.html';

Template.hello.onCreated(function helloOnCreated() {
  // counter starts at 0
  this.counter = new ReactiveVar(0);
});

Template.hello.helpers({

});

Template.hello.events({
  'click .poster' : function(){
    const result =  HTTP.call('POST', ' http://localhost:8090/checkoutSession', {
                  data: {
                      "orderID": "12321123",
                      "orderValue": "233"
                }}, (error, result) => {

                  if (!error) {
                    window.location.replace(result.content);
                  }
  })
  //console.log("hhello");
  //window.location.replace(result.content);
  }
});
