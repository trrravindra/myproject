define(["jquery","stapes","../globals"],function(e,t,n){var r=t.subclass({constructor:function(){var t=this;t.initEvents(),e(function(){t.emit("domready")})},initEvents:function(){var e=this;e.on("domready",e.onDomReady)},onDomReady:function(){alert('I only get loaded if "exampleone" is put in the \ndata-dynamic-script attribute.')}});return new r});