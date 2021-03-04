export class Login {
  protected _login: string;
  private _password: string;
  private _role: String;
  private _statut: boolean;

  constructor(
    login: string = '',
    password: string = '',
    role?: String,
    statut?: boolean
  ) {
    this._login = login;
    this._password = password;
    this._role = role;
    this._statut = statut;
  }

  /**
   * Getter login
   * @return {string}
   */
  public get login(): string {
    return this._login;
  }

  /**
   * Setter login
   * @param {string} value
   */
  public set login(value: string) {
    this._login = value;
  }
  /**
   * Getter password
   * @return {string}
   */
  public get password(): string {
    return this._password;
  }

  /**
   * Setter password
   * @param {string} value
   */
  public set password(value: string) {
    this._password = value;
  }

  /**
   * Getter role
   * @return {String}
   */
  public get role(): String {
    return this._role;
  }

  /**
   * Getter statut
   * @return {boolean}
   */
  public get statut(): boolean {
    return this._statut;
  }

  /**
   * Setter role
   * @param {String} value
   */
  public set role(value: String) {
    this._role = value;
  }

  /**
   * Setter statut
   * @param {boolean} value
   */
  public set statut(value: boolean) {
    this._statut = value;
  }
}
