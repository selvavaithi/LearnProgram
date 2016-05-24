function StartUp() 
{ 
    var xmlReq;
    if (window.XMLHttpRequest)
    {
        //code for IE7+, Firefox, Chrome, Opera, Safari
        xmlReq = new XMLHttpRequest();
    }
    else
    {   //code for IE6, IE5
        xmlReq = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlReq.onreadystatechange = function () 
    
    {  //alert(xmlReq.readyState + " Statuscode= "+ xmlReq.status);
        if (xmlReq.readyState == 4 ) 
        {
            response = xmlReq.responseText;
              alert("response= "+xmlReq.responseText);
              //returnedXMLDoc = loadXMLString(response);
               var strFormIdXML = "";
                var parser = new DOMParser();
                xmlDoc = parser.parseFromString(response,"text/xml");
                strFormIdXML = xmlDoc.getElementsByTagName("distance");                                                            
                  var value1 = strFormIdXML[0].getElementsByTagName("value")[0].textContent;     
                  var value2 = strFormIdXML[0].getElementsByTagName("text")[0].textContent;    
                  alert("Distance value= "+value1);
                  alert("Distance text= "+value2)
               }
    };
    url = "https://maps.googleapis.com/maps/api/directions/xml?origin=Okkiyam+Thuraipakkam&destination=nellore";
    xmlReq.open("GET", url, true);
    xmlReq.setRequestHeader("Content-Type", "text/xml; charset=utf-8");
    xmlReq.send();
}
</script>
