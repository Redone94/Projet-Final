import {
  ListSallesComponent
} from '../salles/list-salles/list-salles.component';
import { Adresse } from './adresse';
import { Compte } from './compte';
import { TypeEtablissement } from './type-etablissement.enum';

export class Etablissement {
  private _id: number;
  private _nom: string;
  private _numeroTel: string;

  private _adresse: Adresse;
  private _typeEtab: TypeEtablissement;
  private _compte: Compte;
  private _salleClasse: ListSallesComponent;
  private _logo: string;

  constructor(
    id?: number,
    nom: string = '',
    numeroTel: string = '',
    adresse?: Adresse,
    compte?: Compte,
    salleClasse?: ListSallesComponent,
    logo: string = '',
    typeEtab: TypeEtablissement = null
  ) {
    this._id = id;
    this._nom = nom;
    this._numeroTel = numeroTel;
    this._adresse = adresse;
    this._compte = compte;
    this._salleClasse = salleClasse;
    this._logo = logo;
    this._adresse = adresse;
    this._typeEtab = typeEtab;
  }

  /**
   * Getter id
   * @return {number}
   */
  public get id(): number {
    return this._id;
  }
  /**
   * Getter typeEtab
   * @return {TypeEtablissement}
   */
  public get typeEtab(): TypeEtablissement {
    return this._typeEtab;
  }
  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Getter numeroTel
   * @return {string}
   */
  public get numeroTel(): string {
    return this._numeroTel;
  }
  /**
   * Getter adresse
   * @return {Adresse}
   */
  public get adresse(): Adresse {
    return this._adresse;
  }
  /**
   * Getter compte
   * @return {Compte}
   */
  public get compte(): Compte {
    return this._compte;
  }

  /**
   * Getter salleClasse
   * @return {ListSallesComponent}
   */
  public get salleClasse(): ListSallesComponent {
    return this._salleClasse;
  }

  /**
   * Getter logo
   * @return {string}
   */
  public get logo(): string {
    return this._logo;
  }

  /**
   * Setter id
   * @param {number} value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string) {
    this._nom = value;
  }
  /**
   * Setter etablissement
   * @param {TypeEtablissement} value
   */
  public set role(value: TypeEtablissement) {
    this._typeEtab = value;
  }
  /**
   * Setter numeroTel
   * @param {string} value
   */
  public set numeroTel(value: string) {
    this._numeroTel = value;
  }

  /**
   * Setter compte
   * @param {Compte} value
   */
  public set compte(value: Compte) {
    this._compte = value;
  }

  /**
   * Setter salleClasse
   * @param {ListSallesComponent} value
   */
  public set salleClasse(value: ListSallesComponent) {
    this._salleClasse = value;
  }

  /**
   * Setter logo
   * @param {string} value
   */
  public set logo(value: string) {
    this._logo = value;
  }
  /**
   * Setter adresse
   * @param {Adresse} value
   */
  public set adresse(value: Adresse) {
    this._adresse = value;
  }
}
