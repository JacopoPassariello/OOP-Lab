#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void player_vs_cpu();
int popola(int *soluzione, int op, int n);

int main (){
	int opzione;
	do{
		
		printf("Inserisci una delle seguenti opzioni \n");
		printf("1 - Player vs CPU \n");
		printf("2 - Player vs Player \n");
		printf("0 - EXIT \n");
		scanf("%d", &opzione);
		
		switch (opzione) {
			case 1:
			    player_vs_cpu();
				break;
			default:
				break;
		}
		
	}while(opzione != 0);
	
	
	return 0;
}

int popola(int *soluzione, int op, int n){
    srand(time(NULL));
	
	int i, k, temp;
	int flag = 0;
	
	if (op == 0){
	for (i = 0; i < n; i++) {
			if (i == 0) {
				temp = rand() % 10;
				soluzione[i] = temp;
			} else {
				do {
					temp = rand() % 10;
					flag = 0;
					for (k = 0; k <= n; k++) {
						if (temp == soluzione[k]) {
							flag = 1;
							printf ("NUMERI UGUALI %d e %d \n", temp, soluzione[k]);
						} 
					}
				} while (flag != 0);
				soluzione[i] = temp;
			}
		}
	} else {
		for (i = 1; i <= n; i++) {
			temp = rand() % 10;
			soluzione[i] = temp;
		}
	}
}

void player_vs_cpu() {
	
	int *soluzione;
	int i, k, n, op;
	
	
	printf("Da quanti numeri deve essere composta la password? \n");
	scanf("%d", &n);
	
	soluzione = malloc(sizeof(int) * n);
	
	printf("Vuoi le ripetizioni? 0 = no | 1 = yes \n");
	scanf("%d", &op);
	
	popola(soluzione, op, n);
	
	for (i = 1; i <= n; i++){
		printf("%d", soluzione[i]);
	}
	
}
