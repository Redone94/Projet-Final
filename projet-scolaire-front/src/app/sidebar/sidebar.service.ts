import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SidebarService {
  toggled = false;
  _hasBackgroundImage = true;
  menus = [
    {
      title: 'general',
      type: 'header',
    },

    {
      title: 'Professeurs',
      icon: 'fa fa-shopping-cart',
      active: false,
      type: 'dropdown',
      badge: {
        text: '3',
        class: 'badge-danger',
      },
      submenus: [
        {
          title: 'Professeur 1',
        },
        {
          title: 'Professeur 2',
        },
        {
          title: 'Professeur 3',
        },
      ],
    },
    {
      title: 'Etablissement',
      icon: 'far fa-gem',
      active: false,
      type: 'dropdown',
      submenus: [
        {
          title: 'Collèges',
        },
        {
          title: 'Ecoles',
        },
        {
          title: 'Lycées',
        },
      ],
    },
    {
      title: 'Matiéres',
      icon: 'fa fa-chart-line',
      active: false,
      type: 'dropdown',
      submenus: [
        {
          title: 'Francais',
        },
        {
          title: 'Mathématique',
        },
        {
          title: 'Histoire / Géographique',
        },
        {
          title: 'Chimie',
        },
      ],
    },
    {
      title: 'Salles',
      icon: 'fa fa-globe',
      active: false,
      type: 'dropdown',
      submenus: [
        {
          title: 'Salle 1',
        },
        {
          title: 'Salle 2',
        },
        {
          title: 'Salle 3',
        },
      ],
    },

    {
      title: 'Classe',
      icon: 'fa fa-book',
      active: false,
      type: 'simple',
      badge: {
        text: 'Beta',
        class: 'badge-primary',
      },
    },
    {
      title: 'Planning',
      icon: 'fa fa-calendar',
      active: false,
      type: 'simple',
    },
  ];
  constructor() {}

  toggle() {
    this.toggled = !this.toggled;
  }

  getSidebarState() {
    return this.toggled;
  }

  setSidebarState(state: boolean) {
    this.toggled = state;
  }

  getMenuList() {
    return this.menus;
  }

  get hasBackgroundImage() {
    return this._hasBackgroundImage;
  }

  set hasBackgroundImage(hasBackgroundImage) {
    this._hasBackgroundImage = hasBackgroundImage;
  }
}
