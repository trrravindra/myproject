define(["jquery","modules/api-tools","modules/dictionary"],function(e,t,n){var r={replaceChar:"*",lang:"en"},i;return i={dict:null,init:function(t){var n=this;return n.options=e.extend({},r,t),n.getData()},filter:function(e){var t=this,n=""+e;if(!t.dict)throw"Dictionary not initialized";return t.dict.eachInText(e,function(e,r){var i=e.length,s=(new Array(i+1)).join(t.options.replaceChar);n=n.substr(0,r)+s+n.substr(r+i,n.length)}),n},findProfanityIn:function(e){var t=this;if(!t.dict)throw"Dictionary not initialized";return t.dict.findInText(e)},getData:function(){var r=this;return t.publicDfd(function(i){if(r.dict)return i.resolve(r.dict);var s=t.prepare("profanity.phrases",{lang:r.options.lang});e.ajax(s).done(function(e){r.dict=n.fromList(e),i.resolve(r.dict)}).fail(function(){i.reject()})},"profdata")}},i});