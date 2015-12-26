jQuery(document).ready(function(){
    $('.qtyplus1').click(function(e){
        // Stop acting like a button
        e.preventDefault();
        function montoAdultos(nroAdultos){
            var f=new Date();
            if (f.getDay()==1 || f.getDay()==3)
            {
                var precioAdulto = 20.00;
            }else if(f.getDay()==2)
            {
                var precioAdulto = 12.00;
            }else{
                var precioAdulto = 28.00;
            }
            var monto = nroAdultos*precioAdulto;
            $('#totalAdultos').val(monto.toString());
        }
        function total(){
            if($('#totalAdultos').val() == ""){
                adultos = 0;
            }else{
                var adultos = parseFloat($('#totalAdultos').val());
            }

            if($('#totalNinos').val() == ""){
                ninos = 0;
            }else{
                var ninos = parseFloat($('#totalNinos').val());
            }

            var total = ninos + adultos;
            console.log(total);
            $('#total').html('S/.'+ total.toString());
        }
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name='+fieldName+']').val());

        // If is not undefined
        if (!isNaN(currentVal) && currentVal >= 0 && currentVal < 5) {
            // Increment
            $('input[name='+fieldName+']').val(currentVal + 1);
            montoAdultos(currentVal+1);
            total();
        } else {
            // Otherwise put a 0 there
            $('input[name='+fieldName+']').val(currentVal);
            montoAdultos(currentVal);
            total();
        }
    });
    // This button will decrement the value till 0
    $(".qtyminus1").click(function(e) {
        // Stop acting like a button
        e.preventDefault();
        function montoAdultos(nroAdultos){
        var f=new Date();
        if (f.getDay()==1 || f.getDay()==3)
        {
            var precioAdulto = 20.00;
        }else if(f.getDay()==2)
        {
            var precioAdulto = 12.00;
        }else{
            var precioAdulto = 28.00;
        }
        var monto = nroAdultos*precioAdulto;
        $('#totalAdultos').val(monto.toString());
    }
        function total(){
            if($('#totalAdultos').val() == ""){
                adultos = 0;
            }else{
                var adultos = parseFloat($('#totalAdultos').val());
            }

            if($('#totalNinos').val() == ""){
                ninos = 0;
            }else{
                var ninos = parseFloat($('#totalNinos').val());
            }

            var total = ninos + adultos;
            console.log(total);
            $('#total').html('S/.'+ total.toString());
        }
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name='+fieldName+']').val());

        // If it isn't undefined or its greater than 0
        if (!isNaN(currentVal) && currentVal > 0) {
            // Decrement one
            $('input[name='+fieldName+']').val(currentVal - 1);
            montoAdultos(currentVal-1);
            total();
        } else {
            // Otherwise put a 0 there
            $('input[name='+fieldName+']').val(currentVal);
            montoAdultos(currentVal);
            total();
        }
    });

    $('.qtyplus2').click(function(e){
        // Stop acting like a button
        e.preventDefault();
        function montoNinos(nroNinos){
            //var diasSemana = new Array("Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado");
            var f=new Date();
            if (f.getDay()==1 || f.getDay()==3)
            {
                var precioNino = 10.00;
            }else if(f.getDay()==2)
            {
                var precioNino = 7.00;
            }else{
                var precioNino = 15.00;
            }
            var monto = nroNinos*precioNino;
            $('#totalNinos').val(monto.toString());
        }
        function total(){
            if($('#totalAdultos').val() == ""){
                adultos = 0;
            }else{
                var adultos = parseFloat($('#totalAdultos').val());
            }

            if($('#totalNinos').val() == ""){
                ninos = 0;
            }else{
                var ninos = parseFloat($('#totalNinos').val());
            }

            var total = ninos + adultos;
            console.log(total);
            $('#total').html('S/.'+ total.toString());
        }
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name='+fieldName+']').val());
        // If is not undefined
        if (!isNaN(currentVal) && currentVal >= 0 && currentVal < 5) {
            // Increment
            $('input[name='+fieldName+']').val(currentVal + 1);
            montoNinos(currentVal+1);
            total();
        } else {
            // Otherwise put a 0 there
            $('input[name='+fieldName+']').val(currentVal);
            montoNinos(currentVal);
            total();
        }
    });

    // This button will decrement the value till 0
    $(".qtyminus2").click(function(e) {
        // Stop acting like a button
        e.preventDefault();
        function montoNinos(nroNinos){
            //var diasSemana = new Array("Domingo","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado");
            var f=new Date();
            if (f.getDay()==1 || f.getDay()==3)
            {
                var precioNino = 10.00;
            }else if(f.getDay()==2)
            {
                var precioNino = 7.00;
            }else{
                var precioNino = 15.00;
            }
            var monto = nroNinos*precioNino;
            $('#totalNinos').val(monto.toString());
        }
        function total(){
            if($('#totalAdultos').val() == ""){
                adultos = 0;
            }else{
                var adultos = parseFloat($('#totalAdultos').val());
            }

            if($('#totalNinos').val() == ""){
                ninos = 0;
            }else{
                var ninos = parseFloat($('#totalNinos').val());
            }

            var total = ninos + adultos;
            console.log(total);
            $('#total').html('S/.'+ total.toString());
        }
        // Get the field name
        fieldName = $(this).attr('field');
        // Get its current value
        var currentVal = parseInt($('input[name='+fieldName+']').val());
        // If it isn't undefined or its greater than 0
        if (!isNaN(currentVal) && currentVal > 0) {
            // Decrement one
            $('input[name='+fieldName+']').val(currentVal - 1);
            montoNinos(currentVal-1);
            total();
        } else {
            // Otherwise put a 0 there
            $('input[name='+fieldName+']').val(currentVal);
            montoNinos(currentVal);
            total();
        }
    });
});