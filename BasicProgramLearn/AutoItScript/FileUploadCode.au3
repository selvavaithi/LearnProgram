#include<IE.au3>
If $CmdLine[0] < 2 Then
$window_name="File Upload"
WinWait($window_name)
ControlFocus($window_name,"","Edit1")
ControlSetText($window_name,"","Edit1",$CmdLine[1])
ControlClick($window_name,"","Button1")
EndIf