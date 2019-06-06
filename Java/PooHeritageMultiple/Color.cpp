/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Color.cpp
 * Author: mk
 * 
 * Created on 31 mai 2019, 08:55
 */

#include "Color.h"
#include <iostream>
using namespace std;

Color::Color(int coul): couleur(coul) {
    cout<<"++Const.color"<<endl;
}

void Color::afficher(){
    cout<<"Ma couleur est: "<<couleur<<endl;
}

Color::~Color(){
    cout<<"delete couleur"<<endl;
}

