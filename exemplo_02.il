.assembly extern mscorlib {}
.assembly exemplo_02{}
.module exemplo_02.exe

.class public _Principal{

.method static public void _principal()
 { 

	  .entrypoint

	  .locals(int64 area,int64 lado)
	  call string [mscorlib]System.Console::ReadLine()
	  call int64 [mscorlib]System.Int64::Parse(string)
	  stloc lado
	  ldloc lado
	  ldloc lado
	  mul
	  stloc area
	  ldloc area
	  call void [mscorlib]System.Console::Write(int64)
	  ret
 }
}