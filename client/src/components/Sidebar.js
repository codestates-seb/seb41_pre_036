import React from "react";
import { useLocation, Link } from "react-router-dom";
import styled from "styled-components";
import LayoutContainer from "./LayoutContainer";

export const SideMenu = styled.div`
  position: fixed;
  display: ${(props) => (props.sidebar ? "block" : "none")};
  width: 240px;
  padding-top: 60px;
  padding-bottom: 10px;
  background-color: #fff;
  z-index: 1;
  box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
    0 2px 8px hsla(0, 0%, 0%, 0.05);
  @media screen and (min-width: 641px) {
    display: block;
    width: 164px;
    height: 100vh;
    border-right: 1px solid #e3e6e8;
    box-shadow: none;
  }
  &.remove {
    @media screen and (min-width: 641px) {
      display: none !important;
      width: 164px;
      height: 100vh;
    }
  }
  p {
    margin-top: 18px;
    padding: 5px 8px;
    font-size: 13px;
    color: hsl(210, 8%, 35%);
    cursor: pointer;
    &:first-child {
      &:hover {
        font-weight: 500;
        color: hsl(210, 8%, 5%);
      }
    }
    &:nth-child(2) {
      cursor: auto;
      color: hsl(210, 8%, 35%);
    }
  }
  ul {
    li {
      position: relative;
      display: flex;
      align-items: center;
      padding: 10px 6px 10px 30px;
      font-size: 13px;
      color: hsl(210, 8%, 35%);
      cursor: pointer;
      &:hover {
        color: hsl(210, 8%, 5%);
        svg {
          opacity: 1;
        }
      }
      svg {
        position: absolute;
        left: 8px;
        margin-top: -1px;
        opacity: 0.7;
      }
    }
  }
`;

const PublicList = styled.li`
  background-color: ${(props) =>
    props.selected ? "hsl(210, 8%, 95%)" : "none"};
  font-weight: ${(props) => (props.selected ? "bolder" : "none")};
  color: ${(props) => (props.selected ? "hsl(210, 8%, 5%)" : "none")};
  border-right: 3px solid ${(props) => (props.selected ? "#f48223" : "none")};
`;

export default function Sidebar() {
  const { pathname } = useLocation();
  return (
    <LayoutContainer>
      <SideMenu>
        <p>Home</p>
        <p>PUBLIC</p>
        <ul>
          <Link to="/">
            <PublicList selected={pathname === "/" ? true : false}>
              <svg
                aria-hidden="true"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path d="M9 1C4.64 1 1 4.64 1 9c0 4.36 3.64 8 8 8 4.36 0 8-3.64 8-8 0-4.36-3.64-8-8-8ZM8 15.32a6.46 6.46 0 0 1-4.3-2.74 6.46 6.46 0 0 1-.93-5.01L7 11.68v.8c0 .88.12 1.32 1 1.32v1.52Zm5.72-2c-.2-.66-1-1.32-1.72-1.32h-1v-2c0-.44-.56-1-1-1H6V7h1c.44 0 1-.56 1-1V5h2c.88 0 1.4-.72 1.4-1.6v-.33a6.45 6.45 0 0 1 3.83 4.51 6.45 6.45 0 0 1-1.51 5.73v.01Z"></path>
              </svg>
              <span>Questions</span>
            </PublicList>
          </Link>
          <Link to="/tags">
            <PublicList selected={pathname === "/tags" ? true : false}>
              Tags
            </PublicList>
          </Link>
          <PublicList selected={pathname === "/users" ? true : false}>
            Users
          </PublicList>
          <PublicList selected={pathname === "/companies" ? true : false}>
            Companies
          </PublicList>
        </ul>
      </SideMenu>
    </LayoutContainer>
  );
}
