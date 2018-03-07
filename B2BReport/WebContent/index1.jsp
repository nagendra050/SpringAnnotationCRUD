<html>
<head>
<style type="text/css">
@import "compass";
@import url("https://fonts.googleapis.com/css?family=Open+Sans");

/* Color settings */
$formBg: #2c3e50;
$formColor: #fff;
$inputBg: #fff;
$inputColor: #000;
$buttonBg: #e67e22;
$buttonColor: #fff;
$errorMsgColor: #ff0000;

/* Styles */
* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Open Sans";
  font-size: 14px;
}

.container {
  width: 500px;
  margin: 25px auto;
}

form {
  padding: 20px;
  background: $formBg;
  color: $formColor;
  @include border-radius(4px);
  
  label,
  input,
  button {
    border: 0;
    margin-bottom: 3px;
    display: block;
    width: 100%;
  }
  input {
    height: 25px;
    line-height: 25px;
    background: $inputBg;
    color: $inputColor;
    padding: 0 6px;
    @include box-sizing(border-box);
  }
  button {
    height: 30px;
    line-height: 30px;
    background: $buttonBg;
    color: $buttonColor;
    margin-top: 10px;
    cursor: pointer;
  }
  .error {
    color: $errorMsgColor;
  }
}

.article-reference {
  margin-top: 15px;
  a {
    color: $buttonBg;
  }
}
</style>
</head>
<div class="container">
  <h2>Registration</h2>
  <form action="" name="registration">

    <label for="firstname">First Name</label>
    <input type="text" name="firstname" id="firstname" placeholder="John">

    <label for="lastname">Last Name</label>
    <input type="text" name="lastname" id="lastname" placeholder="Doe">

    <label for="email">Email</label>
    <input type="email" name="email" id="email" placeholder="john@doe.com">

    <label for="password">Password</label>
    <input type="password" name="password" id="password" placeholder="&#9679;&#9679;&#9679;&#9679;&#9679;">

    <button type="submit">Register</button>
  </form>

  <div class="article-reference">
    This example is part of the article
    <a href="https://www.sitepoint.com/basic-jquery-form-validation-tutorial/" target="_blank">Basic jQuery Form Validation Example</a> on <a href="http://sitepoint.com/" target="_blank">SitePoint</a> by
    <a href="https://github.com/julmot" target="_blank">Julian Motz</a>.
  </div>
</div>
<script type="text/javascript">
//Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='registration']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      firstname: "required",
      lastname: "required",
      email: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true
      },
      password: {
        required: true,
        minlength: 5
      }
    },
    // Specify validation error messages
    messages: {
      firstname: "Please enter your firstname",
      lastname: "Please enter your lastname",
      password: {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long"
      },
      email: "Please enter a valid email address"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
</script>
</html>