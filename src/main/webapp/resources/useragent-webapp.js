$(document).ready(function () {

    console.log("In Document ready  ");

    /////
    $.validator.addMethod("isOptInSelected", function (value, element) {
        var emailRadioChecked = $("#emailsCode").prop("checked");
        var smsRadioChecked = $("#textCode").prop("checked");
        //var optInCodeCheckedNumeric = $("#signInCode").is(":checked") ? 1 : 0;
        //var isOptInCheckBoxSelected = $("#signInCode").prop("checked");
        console.log("\n isOptInSelected with emailRadioChecked {%s} and smsRadioChecked {%s} " +
            //"and isOptInCheckBoxSelected {%s}",
            emailRadioChecked, smsRadioChecked
            //, isOptInCheckBoxSelected
        );
        //if (isOptInCheckBoxSelected) {
        if (emailRadioChecked == false && smsRadioChecked == false) {
            console.log("2 : neither radio checked.");
            return false;
        }
        //}
        return false;
    }, "an error message from isOptInSelected.");


    $('#simpleForm').validate({
        rules: {
            securityCodeValue: "isOptInSelected",
            firstName: "required",
            lastName: "required",
            age: {
                required: true,
                range: [18, 70]
            }
        },
        //errorPlacement: function(error, element) {
        //    if(element.attr("name") == "securityCodeValue") {
        //        console.log("3a: Error in Radio Button {%s} & {} ",element.attr("name"), error.innerHTML);
        //        //error.appendTo('#securityCodeValue');
        //        //error.html($("#sampleErrorMessageBox"));
        //        error.html($("#sampleErrorMessageBox"));
        //    }
        //    else {
        //        console.log("3b Error elsewhere: {%s}",element.attr("name"));
        //        error.insertAfter(element);
        //    }
        //} ,
        errorPlacement: function(error, element) {
            if ( element.is(":radio") ) {
                //error.appendTo( element.parents('.container') );
                console.log(" ERROR IS [%s]", error.text());

                var theDiv = document.getElementById("textDisp");
                theDiv.innerHTML += error.text();
            }
            else { // This is the default behavior
                error.insertAfter( element );
            }
        },
        messages: {
            firstName: "Please enter your first name.",
            lastName: "Please enter your last name.",
            age: {
                required: "Please enter your age.",
                range: "Your age must be between 18 and 70."
            }
        }
        //, errorContainer: $('#errorContainer'),
        //errorLabelContainer: $('#errorContainer ul'),
        //wrapper: 'li'
    });


});
