Accounts.onLogin(function(){
  FlowRouter.go('home');
});

Accounts.onLogout(function(){
  FlowRouter.go('home');
});

FlowRouter.triggers.enter([function(context, redirect){
  if(!Meteor.userId()){
    FlowRouter.go('home');
  }
}]);

FlowRouter.route('/', {
  name:'home',
  action() {
    // if(Meteor.userId()){
    //   FlowRouter.go('host-dinner');
    // }
  BlazeLayout.render('MainLayout', {main: 'submitData'});
  }
});

FlowRouter.route('/home', {
  name:'home-page',
  action() {
    BlazeLayout.render('MainLayout', {main: 'submitData'});
  }
});

FlowRouter.route('/accept', {
  name:'accept-page',
  action() {
    BlazeLayout.render('MainLayout', {main: 'submitData'});
  }
});

FlowRouter.route('/cancel', {
  name:'cancel-page',
  action() {
    BlazeLayout.render('MainLayout', {main: 'submitData'});
  }
});
