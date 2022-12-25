import React from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";
import LayoutContainer from "./LayoutContainer";

export const Container = styled.footer`
  padding: 16px;
  background-color: hsl(210, 8%, 15%);
  color: hsl(210, 8%, 75%);
  font-size: 11px;
  position: relative;
  z-index: 2;
  &.remove {
    display: none;
  }
  @media screen and (min-width: 641px) {
    padding: 24px;
    font-size: 13px;
  }
  @media screen and (min-width: 880px) {
    padding: 28px 12px;
  }
  a {
    display: inline-block;
  }
  svg {
    display: none;
    @media screen and (min-width: 641px) {
      display: block;
    }
  }
  > div {
    @media screen and (min-width: 981px) {
      display: flex;
      justify-content: space-between;
    }
  }
`;

export const MediumContainer = styled.div`
  @media screen and (min-width: 641px) {
    display: flex;
    gap: 30px;
  }
  @media screen and (min-width: 981px) {
    width: 100%;
  }
`;

export const Categories = styled.ul`
  @media screen and (min-width: 641px) {
    margin-top: 30px;
  }
  @media screen and (min-width: 817px) {
    display: inline-flex;
    width: calc(100% - 37px);
  }
`;

export const Categoriy = styled.li`
  padding: 0 12px 24px 0;
  @media screen and (min-width: 817px) {
    width: 100%;
    margin-left: 30px;
  }
  @media screen and (min-width: 981px) {
    width: 25%;
  }
  > p {
    font-weight: 800;
    margin-bottom: 8px;
    white-space: nowrap;
  }
  ul {
    display: flex;
    flex-wrap: wrap;
    column-gap: 12px;
    row-gap: 8px;
    color: hsl(210, 8%, 60%);
    font-weight: 400;
    @media screen and (min-width: 817px) {
      flex-direction: column;
    }
    li {
      cursor: pointer;
      white-space: nowrap;
      &:hover {
        color: hsl(210, 8%, 65%);
      }
      a {
        color: inherit;
      }
    }
  }
`;

export const SocialsAndCopy = styled.ul`
  font-size: 11px;
  color: hsl(210, 8%, 60%);
  margin-top: 24px;
  @media screen and (min-width: 641px) {
    font-size: 13px;
  }
  @media screen and (min-width: 880px) {
    margin-left: 24px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }
  @media screen and (min-width: 981px) {
    width: 347px;
  }
  ul {
    display: flex;
    flex-wrap: wrap;
    column-gap: 12px;
    row-gap: 8px;
    color: hsl(210, 8%, 60%);
    font-weight: 400;
    margin-bottom: 8px;
    li {
      cursor: pointer;
      &:hover {
        color: hsl(210, 8%, 65%);
      }
    }
  }
`;

export default function Footer() {
  return (
    <Container>
      <LayoutContainer>
        <MediumContainer>
          <Link to="/">
            <svg aria-hidden="true" width="32" height="37" viewBox="0 0 32 37">
              <path d="M26 33v-9h4v13H0V24h4v9h22Z" fill="#BCBBBB"></path>
              <path
                d="m21.5 0-2.7 2 9.9 13.3 2.7-2L21.5 0ZM26 18.4 13.3 7.8l2.1-2.5 12.7 10.6-2.1 2.5ZM9.1 15.2l15 7 1.4-3-15-7-1.4 3Zm14 10.79.68-2.95-16.1-3.35L7 23l16.1 2.99ZM23 30H7v-3h16v3Z"
                fill="#F48024"
              ></path>
            </svg>
          </Link>
          <Categories>
            <Categoriy>
              <p>STACK OVERFLOW</p>
              <ul>
                <li>
                  <Link to="/">Questions</Link>
                </li>
                <li>Help</li>
              </ul>
            </Categoriy>
            <Categoriy>
              <p>PRODUCTS</p>
              <ul>
                <li>Teams</li>
                <li>Advertising</li>
                <li>Collectives</li>
                <li>Talent</li>
              </ul>
            </Categoriy>
            <Categoriy>
              <p>COMPANY</p>
              <ul>
                <li>About</li>
                <li>Press</li>
                <li>Work Here</li>
                <li>Legal</li>
                <li>Privacy Policy</li>
                <li>Terms of Service</li>
                <li>Contact Us</li>
                <li>Cookis Settings</li>
                <li>Cookis Policy</li>
              </ul>
            </Categoriy>
            <Categoriy>
              <p>STACK EXCHANGE NETWORK</p>
              <ul>
                <li>Technology</li>
                <li>Culture &#38; recreation</li>
                <li>Life &#38; arts</li>
                <li>Science</li>
                <li>Professional</li>
                <li>Business</li>
                <li>API</li>
                <li>Data</li>
              </ul>
            </Categoriy>
          </Categories>
        </MediumContainer>
        <SocialsAndCopy>
          <li>
            <ul>
              <li>Blog</li>
              <li>Facebook</li>
              <li>Twitter</li>
              <li>LinkedIn</li>
              <li>Instagram</li>
            </ul>
          </li>
          <li>
            Site design / logo © 2022 Stack Exchange Inc; user contributions
            licensed under CC BY-SA. rev 2022.10.25.33519
          </li>
        </SocialsAndCopy>
      </LayoutContainer>
    </Container>
  );
}
