function checkEmail() {
  var emailChecker = new ScalaJS.classes.example_EmailChecker();
  var email = document.forms[0].email.value;
  if (emailChecker.isValid(email))
    console.log("Send to server");
  else
    alert(ScalaJS.modules.example_Messages().notSupported(email))
}
