/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Point.cpp
 * Author: mk
 * 
 * Created on 31 mai 2019, 08:42
 */

#include "Point.h"
#include <iostream>

using namespace std;

Point::Point(int abs, int ord): y(ord), x(abs){
    cout<<"++ Constr.point "<<endl;
    
}

void Point::afficher(){
    cout<<"Mes coordonnées sont: "<<x<<" "<<y<<endl;
}

Point::~Point(){
    cout<<"Destr.point"<<endl;
}






