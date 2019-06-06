/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: mk
 *
 * Created on 31 mai 2019, 08:42
 */

#include <iostream>

#include "PointColored.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    PointColored monPointColore (15,5,3);
    monPointColore.afficher();
    cout<<"-----------------------"<<endl;
    monPointColore.Point::afficher();
    cout<<"-----------------------"<<endl;
    monPointColore.Color::afficher();

    return 0;
}

