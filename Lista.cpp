#include <iostream>
#include <vector>
#include <unordered_set>
#include <cstdlib>
#include <ctime>

std::vector<int> gerarListaAleatoria(int M) {
    std::vector<int> lista;
    for (int i = 0; i < M; ++i) {
        lista.push_back(rand() % 100);
    }
    return lista;
}
a
void mostrarLista(const std::vector<int>& lista) {
    for (int num : lista) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
}

void mostrarNumerosRepetidos(const std::vector<std::vector<int>>& listas) {
    std::unordered_set<int> numerosRepetidos;

    for (const auto& lista : listas) {
        std::unordered_set<int> numerosLista;
        for (int num : lista) {
            if (numerosLista.count(num) > 0) {
                numerosRepetidos.insert(num);
            } else {
                numerosLista.insert(num);
            }
        }
    }

    std::cout << "Números que aparecem nas listas: ";
    for (int num : numerosRepetidos) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
}

void mostrarNumerosUnicos(const std::vector<std::vector<int>>& listas) {
    std::unordered_set<int> todosNumeros;
    std::unordered_set<int> numerosRepetidos;

    for (const auto& lista : listas) {
        for (int num : lista) {
            if (todosNumeros.count(num) > 0) {
                numerosRepetidos.insert(num);
            } else {
                todosNumeros.insert(num);
            }
        }
    }

    std::cout << "Números que aparecem somente em uma das listas: ";
    for (int num : todosNumeros) {
        if (numerosRepetidos.count(num) == 0) {
            std::cout << num << " ";
        }
    }
    std::cout << std::endl;
}

int main() {
    srand(time(nullptr));

    int N, M;
    std::cout << "Digite o número de listas (N): ";
    std::cin >> N;
    std::cout << "Digite o tamanho das listas (M): ";
    std::cin >> M;

    std::vector<std::vector<int>> listas;
    for (int i = 0; i < N; ++i) {
        listas.push_back(gerarListaAleatoria(M));
    }

    std::cout << "Conteúdo das listas:" << std::endl;
    for (const auto& lista : listas) {
        mostrarLista(lista);
    }

    mostrarNumerosRepetidos(listas);

    mostrarNumerosUnicos(listas);

    return 0;
}
