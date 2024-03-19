import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {UserStorageService} from "../storage/user-storage.service";
import { map } from 'rxjs/operators';


const BASIC_URL = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http : HttpClient, private userStorageService: UserStorageService) { }

  register(registerRequest: any) : Observable<any>{
    return this.http.post(BASIC_URL + "register", registerRequest);
  }

  login(username: string, password: string): any
  {
      const headers = new HttpHeaders().set('Content-Type', 'application/json');
      const body = {username, password};

      return this.http.post(BASIC_URL + 'authenticate', body, { headers, observe: 'response'}).pipe(
        map((res: any): boolean =>{
          const token = res.headers.get('authorization').substring(7);
          const user = res.body;
          if(token && user){
            this.userStorageService.saveToken(token);
            this.userStorageService.saveUser(user);

            return true;
          }

          return false;
        })
      )
  }
}
