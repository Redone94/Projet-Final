export class Login {
  protected _login: string;
  private _password: string;
  roles: String;

  constructor(login: string = '', password: string = '', roles?: String) {
    this._login = login;
    this._password = password;
    this.roles = roles;
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
}
