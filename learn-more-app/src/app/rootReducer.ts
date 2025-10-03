// src/app/rootReducer.ts
import { combineReducers } from "@reduxjs/toolkit";
import loginReducer from "../features/auth/LoginSlice";

export const rootReducer = combineReducers({
  auth: loginReducer,
});

export type RootState = ReturnType<typeof rootReducer>;