define(["jquery","stapes","modules/api-tools"],function(e,t,n){var r=t.subclass({constructor:function(){var e=this;e.initEvents()},initEvents:function(){var e=this},quickRating:function(t){var r=this;return n.publicDfd(function(i){var s=n.prepare("post","ratingsApi.quickRating",{id:t.id,rating:t.rating});e.ajax(s).done(function(e){i.resolve()}).fail(function(e,t,s){i.reject(),r.emit("error",n.formatError(e,t,s))})},t)}});return new r});