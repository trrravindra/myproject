define(["jquery","stapes"],function(e,t){var n={},r=t.subclass({constructor:function(t){var r=this;r.config=e.extend({},n,t),r.setupClickAnalytics()},setupClickAnalytics:function(){var t=this,n=t.config;e(".flyer-download").on("click",function(n){var r=e(this).attr("href");t.fireClickAnalytics({category:"global",action:"engagement:download",label:r,value:"",event:"GA Event"})}),e(".newsletter-box a").on("click",function(n){var r=e(this).attr("href");t.fireClickAnalytics({category:"global",action:"engagement:download",label:r,value:"",event:"GA Event"})}),e(".social-connect a").on("click",function(n){var r=e(this).attr("href");r.search("twitter")!=-1?t.fireClickAnalytics({category:"global",action:"outgoing:social",label:"outgoing:twitter",value:"",event:"GA Event"}):r.search("facebook")!=-1&&t.fireClickAnalytics({category:"global",action:"outgoing:social",label:"outgoing:facebook",value:"",event:"GA Event"})}),e(".flex-control-nav li").on("click",function(n){var r=e(".flex-control-nav li").index(e(this));t.fireClickAnalytics({category:"global",action:"engagement:carousel:impression",label:"slide"+r,value:"",event:"GA Event"})}),e(".nutshell-home-carousel li").on("click",function(n){var r=e(".nutshell-home-carousel li").index(e(this));t.fireClickAnalytics({category:"global",action:"engagement:carousel:impression",label:"slide"+r,value:"",event:"GA Event"})}),e("body").on("click",".ns-overlay li",function(n){var r=t.clean(e(this).find("h4").text());t.fireClickAnalytics({category:"global",action:"engagement:change store",label:r,value:"",event:"GA Event"})}),e("body").on("click",".change-store",function(e){t.fireClickAnalytics({event:"pageview",pageview:"change store"})}),e(".about-section-details a").on("click",function(n){var r=e(this).attr("href");t.fireClickAnalytics({category:"global",action:"engagement:download",label:r,value:"",event:"GA Event"})}),e(".store-map-container a").on("click",function(e){t.fireClickAnalytics({category:"global",action:"outgoing:link",label:"outgoing:google maps",value:"",event:"GA Event"})}),e(".store-details .tile-content a").on("click",function(n){var r=e(this).attr("href");if(r.search("mail")!=-1){var i=r.split(":");t.fireClickAnalytics({category:"global",action:"outgoing:emails",label:i[1],value:"",event:"GA Event"})}else t.fireClickAnalytics({category:"global",action:"outgoing:link",label:"outgoing:ontario college of pharmacist",value:"",event:"GA Event"})}),e(".direction-details p a").on("click",function(n){var r=e(this).attr("href");r.search("ttc")!=-1&&t.fireClickAnalytics({category:"global",action:"outgoing:link",label:"outgoing:www.ttc.ca",value:"",event:"GA Event"})})},fireClickAnalytics:function(e){if(typeof dataLayer!="undefined")try{dataLayer.push(e)}catch(t){consoleLog(t)}},clean:function(t){var n=e.trim(t.replace(/[^a-zA-Z0-9 _-]/gi,"").replace(/\s{2,}/g," ")).toLowerCase();return n},consoleLog:function(e){typeof console!="undefined"&&console.log(e)}});return function(e){return new r(e)}});