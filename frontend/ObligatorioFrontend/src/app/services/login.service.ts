import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ILogin } from '../interfaces/login';
import { Observable, catchError, of, tap } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginUrl = 'http://localhost:8080/api/login';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }
  sendLogin( logId: number,  password:string) {
    return this.http.post<ILogin>(this.loginUrl, { logId, password }, this.httpOptions)
    .pipe(
      tap(_ => console.log('fetched employees')),
      catchError(this.handleError<ILogin[]>('sendLogin', []))
    );
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
