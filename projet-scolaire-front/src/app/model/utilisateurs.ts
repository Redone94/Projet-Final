import { Etablissement } from './etablissement';

export class Utilisateurs {
  private _id: number;
  private _login: string;
  private _password: string;
  private _mail: string;
  private _tel: string;
  private _etablissement: Etablissement;

  constructor(
    id?: number,
    login: string = '',
    password: string = '',
    mail: string = '',
    tel: string = '',
    etablissement?: Etablissement
  ) {
    this._id = id;
    this._login = login;
    this._password = password;
    this._mail = mail;
    this._tel = tel;
    this._etablissement = etablissement;
  }

  /**
   * Getter id
   * @return {number}
   */
  public get id(): number {
    return this._id;
  }

  /**
   * Getter login
   * @return {string}
   */
  public get login(): string {
    return this._login;
  }

  /**
   * Getter password
   * @return {string}
   */
  public get password(): string {
    return this._password;
  }

  /**
   * Getter mail
   * @return {string}
   */
  public get mail(): string {
    return this._mail;
  }

  /**
   * Getter tel
   * @return {string}
   */
  public get tel(): string {
    return this._tel;
  }

  /**
   * Getter etablissement
   * @return {Etablissement}
   */
  public get etablissement(): Etablissement {
    return this._etablissement;
  }

  /**
   * Setter id
   * @param {number} value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Setter login
   * @param {string} value
   */
  public set login(value: string) {
    this._login = value;
  }

  /**
   * Setter password
   * @param {string} value
   */
  public set password(value: string) {
    this._password = value;
  }

  /**
   * Setter mail
   * @param {string} value
   */
  public set mail(value: string) {
    this._mail = value;
  }

  /**
   * Setter tel
   * @param {string} value
   */
  public set tel(value: string) {
    this._tel = value;
  }

  /**
   * Setter etablissement
   * @param {Etablissement} value
   */
  public set etablissement(value: Etablissement) {
    this._etablissement = value;
  }
}
