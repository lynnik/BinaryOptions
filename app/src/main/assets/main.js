$(function () {

	$('.menu').on('click', function () {
		$('.menu-hidden').addClass('menu-show');
	});

	$('.cross').on('click', function () {
		$('.menu-hidden').removeClass('menu-show');
	})

});