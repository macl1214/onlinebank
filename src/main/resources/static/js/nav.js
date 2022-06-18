jQuery(document).ready(function($) {
  var alterClass = function() {
    var ww = document.body.clientWidth;
    //console.log(document);
    if (ww < 1000) {
			$('.reg-image').hide();
      $('.reg-form').removeClass('col-4');
      $('.reg-form').addClass('offset-2 col-8');
    } else if (ww >= 1001) {
			$('.reg-form').addClass('col-4');
      $('.reg-form').removeClass('col-8 offset-2');
      $('.reg-image').show();
    };
  };
  $(window).resize(function(){
    alterClass();
  });
  //Fire it when the page first loads:
  alterClass();
});