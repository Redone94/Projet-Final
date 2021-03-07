export class Adresse {
  private _numero: number;
  private _voie: string;
  private _ville: string;
  private _cp: number;

  constructor(
    numero?: number,
    voie: string = '',
    ville: string = '',
    cp?: number
  ) {
    this._numero = numero;
    this._voie = voie;
    this._ville = ville;
    this._cp = cp;
  }

  /**
   * Getter numero
   * @return {number}
   */
  public get numero(): number {
    return this._numero;
  }

  /**
   * Getter voie
   * @return {string}
   */
  public get voie(): string {
    return this._voie;
  }

  /**
   * Getter ville
   * @return {string}
   */
  public get ville(): string {
    return this._ville;
  }

  /**
   * Setter numero
   * @param {number} value
   */
  public set numero(value: number) {
    this._numero = value;
  }

  /**
   * Setter voie
   * @param {string} value
   */
  public set voie(value: string) {
    this._voie = value;
  }

  /**
   * Setter ville
   * @param {string} value
   */
  public set ville(value: string) {
    this._ville = value;
  }

  /**
   * Getter cp
   * @return {number}
   */
  public get cp(): number {
    return this._cp;
  }

  /**
   * Setter cp
   * @param {number} value
   */
  public set cp(value: number) {
    this._cp = value;
  }
}
