$(function() {

        	  $('.check_All').on('click', function() {

        	  	if ( $(this).prop('checked') ) {
        		  	$('div input[type="checkbox"]').each(function() {
        		  		$(this).prop('checked', true);
        	        $(this).closest('div').addClass('active');
        		  	})
        	  	} else {
        	  		$('div input[type="checkbox"]').each(function() {
        		  		$(this).prop('checked', false);
        	        $(this).closest('div').removeClass('active');
        		  	})
        	  	}

        	  });

        	  $('div[scope="row"] input[type="checkbox"]').on('click', function() {
        	    if ( $(this).closest('div').hasClass('active') ) {
        	      $(this).closest('div').removeClass('active');
        	    } else {
        	      $(this).closest('div').addClass('active');
        	    }
        	  });

        	    

        	});