$(window).on('resize', function() {
    if($(window).width() > 992) {
        $('#page').addClass('container');
				$('.navbar-collapse').addClass('row')
				$('.navbar-nav').addClass('justify-content-end')
				$('.navbar-nav').addClass('text-center')
    }
    else {
        $('#page').removeClass('container');
				$('.navbar-collapse').removeClass('row')
				$('.navbar-nav').removeClass('justify-content-end')
				$('.navbar-nav').removeClass('text-center')
    }
})