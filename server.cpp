
#include <stdio.h>
using namespace std;
int main(){
int tasks;
int T;
scanf("%d %d",&tasks,&T);
int resultado=0;
int suma=0;
bool salida=false;
for(int i=0;i<tasks && !salida;i++){
int actual;
scanf("%d", &actual);
resultado+=actual;
if(resultado<=T){
suma++;
}else{
salida=true;
}
}
printf("%d\n", suma);

return 0;
}
