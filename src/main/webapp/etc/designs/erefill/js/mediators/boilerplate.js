define(["jquery","stapes","./globals","modules/carousel"],function(e,t,n,r){var i=t.subclass({constructor:function(){var t=this;t.initEvents(),e(function(){t.emit("domready")})},initEvents:function(){var e=this;e.on("domready",e.onDomReady)},onDomReady:function(){var e=this;e.initHeroCarousel(),n.cookieManager.setCookie("test","testtesttesttest")},initHeroCarousel:function(){var t=this,n=e(".carousel-hero").data("carousel-config"),i=r(n);t.set("carousel-hero",i)}});return new i});