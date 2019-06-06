/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Color.h
 * Author: mk
 *
 * Created on 31 mai 2019, 08:55
 */

#ifndef COLOR_H
#define COLOR_H

class Color {
public:
    Color(int);
    void afficher();
    virtual ~Color();
private:
    short couleur;

};

#endif /* COLOR_H */

