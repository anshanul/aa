function validateForm()
{
var firstname=document.getElementbyId["save"]["firstName"].value;
var lastname=document.getElementbyId["save"]["lastName"].value;

if (firstname==null || firstname=="")
  {
  alert("First name must be filled out");
  return True;
  }
if (lastname==null || lastname=="")
{
alert("Last name must be filled out");
return True;
}

}