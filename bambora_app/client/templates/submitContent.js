import { Template } from 'meteor/templating';
import { ReactiveVar } from 'meteor/reactive-var';
import { HTTP } from 'meteor/http';

import './submitContent.html';

Template.submitData.onCreated(function submitDataOnCreated() {
  // counter starts at 0
  this.counter = new ReactiveVar(0);
});

Template.submitData.helpers({
// var value = document.getElementById('test').value;
});

Template.submitData.events({
  'click .poster' : function(){
    const result =  HTTP.call('POST', ' http://localhost:8090/checkoutSession', {
                  data: {
                      "orderID": document.getElementById('orderID').value,
                      "orderValue": document.getElementById('orderValue').value
                }}, (error, result) => {
                  if (!error) {
                    // window.location.replace(result.content);
                  console.log(result.content);
                  }
  })
  //console.log("hhello");
  //window.location.replace(result.content);
  }
});
