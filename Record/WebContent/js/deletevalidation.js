function validateFormone()
{
var firstname=document.forms["remove"]["firstName"].value;
if (firstname==null || firstname=="")
  {
  alert("First name must be filled out");
  return false;
  }

}
