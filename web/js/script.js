jQuery(document).ready(function() {
    $('#more').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        $("#cantidad2").removeClass('hidden');
        $('#more').addClass('hidden');
        //$('#cantNino').removeClass('hidden');
    });
});
