define(["jquery","stapes","../../mediators/globals"],function(e,t,n){function f(){r.on("managerReady",function(){l()})}function l(){if(n.cookieManager.getCookieByName(o.USER_SESSION_COOKIE))u=!0,h();else if(window.hasOwnProperty(o.GLOBAL_USER_SESSION_OBJECT)){a=window[o.GLOBAL_USER_SESSION_OBJECT];try{delete window[o.GLOBAL_USER_SESSION_OBJECT]}catch(e){window[o.GLOBAL_USER_SESSION_OBJECT]=undefined}c()}else p()}function c(){if(window.hasOwnProperty(o.GLOBAL_USER_SESSION_OBJECT)){var e=JSON.stringify(window[o.GLOBAL_USER_SESSION_OBJECT]);n.cookieManager.setCookie(o.USER_SESSION_COOKIE,e,!1)}else p()}function h(){console.log("Set user data from cookie")}function p(){u=!1,a={isLoggedIn:!1}}var r,i={},s={},o={USER_SESSION_COOKIE:"user_session",GLOBAL_USER_SESSION_OBJECT:"userSessionData"},u=!1,a={},d=t.subclass({events:{LOGIN_SUCCESSFUL:"UserSessionManager.loginSuccesful",LOGIN_FAILED:"UserSessionManager.loginFailed"},constructor:function(t){r=this,i=e.extend({},s,t),f(),e(function(){r.emit("managerReady")})},isLoggedIn:function(){return u},getUserData:function(){return a}});return function(e){return r||new d(e)}});