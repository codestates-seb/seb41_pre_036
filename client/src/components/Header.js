import React, { useState } from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";
import LogoImg from "../assets/sprites.svg";
import DefaultAvatar from "../assets/default-avatar.svg";
import Icon from "../assets/favicons.png";
import { useSelector } from "react-redux";

export const Gnb = styled.header`
  position: fixed;
  display: flex;
  width: 100%;
  height: 47px;
  background-color: hsl(210, 8%, 97.5%);
  box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
    0 2px 8px hsla(0, 0%, 0%, 0.05);
  border-top: 3px solid #f48223;

  z-index: 2;
  > div {
    display: flex;

    width: 100%;
    max-width: 1215px;
    padding: 0 12px 0 0;
    margin: 0 auto;
  }
`;

export const MobileMenuBtn = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 47px;
  height: 47px;
  @media screen and (min-width: 641px) {
    display: none;
  }
  > span {
    position: relative;
    display: inline-block;
    width: 16px;
    height: 2px;
    background-color: hsl(210, 8%, 35%);
    transform: ${(props) => (props.sidebar ? "rotate(45deg)" : "rotate(0)")};
    transition: 0.1s;
    cursor: pointer;
    &:before,
    &:after {
      content: "";
      position: absolute;
      display: inline-block;
      width: 16px;
      height: 2px;
      background-color: hsl(210, 8%, 35%);
    }
    &:before {
      top: ${(props) => (props.sidebar ? "0px" : "-5px")};
      transform-origin: center;
      transform: ${(props) => (props.sidebar ? "rotate(90deg)" : "rotate(0)")};
    }
    &:after {
      bottom: -5px;
      opacity: ${(props) => (props.sidebar ? "0" : "1")};
      transform-origin: center;
    }
  }
`;

export const Logo = styled.div`
  display: inline-flex;
  align-items: center;
  height: 100%;
  padding: 0 8px;
  margin-left: 15px;
  cursor: pointer;
  @media screen and (min-width: 641px) {
    padding: 0 8px;
    margin-left: 0;
  }
  &:hover {
    background-color: hsl(210, 8%, 90%);
  }
  > p {
    display: inline-block;
    width: 25px;
    height: 34px;
    background-image: url(${LogoImg});
    background-repeat: no-repeat;
    background-position: 0 -500px;
    @media screen and (min-width: 641px) {
      width: 150px;
      background-position: 0 -500px;
    }
  }
`;

export const MenuNav = styled.nav`
  display: flex;
  align-items: center;
  justify-content: flex-start;
  gap: 5px;
  font-size: 14px;
  color: hsl(210, 8%, 35%);
  &:hover {
    color: hsl(210, 8%, 15%);
  }
  > p {
    display: none;
    padding: 8px 12px;
    border-radius: 1000px;
    white-space: nowrap;
    cursor: pointer;
    &:hover {
      background-color: hsl(210, 8%, 90%);
    }
    &:nth-child(2) {
      display: inline-block;
    }
    @media screen and (min-width: 880px) {
      display: inline-block;
    }
  }
`;

export const LoginNav = styled.nav`
  width: 100%;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  gap: 5px;
  ul {
    display: flex;
    height: 100%;
    li {
      display: flex;
      align-items: center;
      padding: 0 7px;
      cursor: pointer;
      &.popup-btn {
        position: relative;
      }
      span {
        display: flex;
        align-items: center;
        width: 100%;
        height: 100%;
      }
      &:hover {
        background-color: hsl(210, 8%, 90%);
      }
      svg {
        opacity: 0.7;
        &:hover {
          opacity: 1;
        }
      }
      &.green {
        svg {
          fill: #3d8f58;
          opacity: 1;
        }
      }
    }
  }
`;

export const MyPageBtn = styled.li`
  padding: 0;
  > a {
    display: flex;
    align-items: center;
    height: 100%;
    width: 100%;
  }
`;

export const HeaderAvatar = styled.p`
  width: 24px;
  height: 24px;
  border-radius: 3px;
  background-image: ${(props) =>
    props.img ? `url(${props.img})` : `url(${DefaultAvatar})`};
`;

export const SearchIcon = styled.div`
  display: ${(props) => (props.visible ? "block" : "none")};
  position: absolute;
  left: 19px;
  top: 65px;
  z-index: 1;
  opacity: 0.5;
  @media screen and (min-width: 641px) {
    display: block;
    position: unset;
    left: unset;
    top: 1px;
    transform: translate(177%, 1px);
  }
`;

export const Search = styled.input`
  position: fixed;
  left: 10px;
  top: 61px;
  width: calc(100% - 20px);
  height: 32.6px;

  padding-left: 34px;
  border: 1px solid hsl(210, 8%, 75%);
  border-radius: 2px;
  display: ${(props) => (props.visible ? "block" : "none")};
  &:focus-visible {
    width: 100%;
    border: none;
    outline: 1px solid hsl(206, 90%, 69.5%);
    box-shadow: 0 0 0 4px #d7e5f2;
  }
  &::placeholder {
    color: hsl(210, 8%, 75%);
  }
  @media screen and (min-width: 641px) {
    position: relative;
    top: unset;
    left: unset;
    display: inline-block;
    transform: unset;
    width: 100%;
  }
  &:focus ~ div {
    display: block;
  }
`;

export const SearchGroup = styled.div`
  position: relative;
  @media screen and (min-width: 641px) {
    width: 100%;
  }
`;

export const SearchDropDown = styled.div`
  display: none;
  position: fixed;
  left: 10px;
  top: 100px;
  width: 96vw;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 1px 3px hsla(0, 0%, 0%, 0.06), 0 2px 6px hsla(0, 0%, 0%, 0.06),
    0 3px 8px hsla(0, 0%, 0%, 0.09);
  @media screen and (min-width: 641px) {
    position: absolute;
    bottom: -179px;
    top: unset;
    left: 0;
    width: 100%;
    min-width: 420px;
  }
  > div {
    display: flex;
    padding: 12px;
    @media screen and (min-width: 641px) {
      display: unset;
    }
    &:first-child {
      display: flex;
      flex-direction: column;
      @media screen and (min-width: 641px) {
        flex-direction: row;
      }
      ul:first-child {
        margin-bottom: 12px;
      }
    }
    &:nth-child(2) {
      display: flex;
      align-items: center;
      justify-content: space-between;
      border-top: 1px solid hsl(210, 8%, 90%);
    }
    ul {
      display: flex;
      flex-direction: column;
      gap: 12px;
      width: 50%;
      font-size: 12px;
      li {
        white-space: nowrap;
        cursor: auto;
        :hover {
          background-color: unset;
        }
        span {
          margin-left: 5px;
          color: #6a737c;
        }
      }
    }
    p {
      padding: 0.6em;
      background-color: #e1ecf4;
      color: #39739d;
      border: 1px solid #39739d;
      border-radius: 4px;
      font-size: 11px;
      cursor: pointer;
      &:hover {
        background-color: hsl(205, 57%, 81%);
      }
    }
    small {
      font-size: 11px;
      color: #0074cc;
    }
  }
`;

export const SearchArrow = styled.div`
  display: none;
  position: fixed;
  left: 10px;
  top: 92px;
  width: calc(100% - 20px);
  @media screen and (min-width: 641px) {
    position: unset;
    left: unset;
    top: unset;
    width: auto;
  }
  &:before,
  &:after {
    content: "";
    width: 10px;
    height: 10px;
    position: absolute;
    left: 50%;
    transform: translate(-50%, 28%) rotate(45deg);
    background-color: #fff;
  }
  &::before {
    box-shadow: -1px -1px 1px 0 hsl(0deg 0% 0% / 12%);
  }
`;

export const MobileSearchButton = styled.div`
  display: flex;
  align-items: center;
  padding: 0 10px;
  height: 100%;
  opacity: 0.7;
  cursor: pointer;
  @media screen and (min-width: 641px) {
    display: none;
  }
`;

export const Button = styled.div`
  height: 30px;

  padding: 8.4px 8px 6.4px 8px;
  border-radius: 2px;
  border: 1px solid black;
  font-size: 13px;
  vertical-align: middle;
  cursor: pointer;
  white-space: nowrap;
  flex-shrink: 0;
  background-color: ${(props) =>
    props.sky ? "hsl(205,46%,92%)" : "hsl(206,100%,52%)"};
  border-color: ${(props) =>
    props.sky ? "hsl(205,41%,63%)" : "hsl(206,100%,52%)"};
  color: ${(props) => (props.sky ? "hsl(205,47%,42%)" : "hsl(0,0%,100%)")};
  &:hover {
    background-color: ${(props) =>
      props.sky ? "hsl(205,57%,81%)" : "hsl(206,100%,40%)"};
    color: ${(props) => (props.sky ? "hsl(205,46%,32%)" : "hsl(0,0%,100%)")};
  }
`;

export const LogoutPop = styled.div`
  position: absolute;
  right: -12px;
  top: 44px;
  width: 100vw;
  background-color: hsl(210, 8%, 95%);

  box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05),
    0 2px 8px hsla(0, 0%, 0%, 0.05);
  @media screen and (min-width: 641px) {
    width: 363px;
  }
  header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 8px 10px;
    p {
      font-size: 11px;
      font-weight: 800;
      color: #0074cc;
      &:hover {
        color: rgb(10, 149, 255);
      }
    }
    svg {
      width: 18px;
      height: 18px;
    }
  }
`;

export const MenuRows = styled.div`
  display: block;
  background-color: hsl(205, 47%, 97%);
`;

export const Row = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
  > div {
    display: flex;
    align-items: center;
    gap: 6px;
    padding: 8px;
    font-size: 12px;
    color: #0074cc;
    a {
      color: #0074cc;
      &:hover {
        color: hsl(206, 100%, 52%);
      }
    }
    &:nth-child(2) {
      gap: 10px;
    }
    span {
      font-size: 12px;
    }
  }
  &.second {
    padding: 0 4px;
    > div:first-child {
      font-weight: 800;
      span {
        display: inline-block;
        width: 16px;
        height: 16px;
        background-image: url(${Icon});
        background-size: 16px 7038px;
        background-position: 0 -6138px;
      }
    }
  }
  &.third {
    padding: 0 10px;
    > div:first-child {
      .icon {
        display: inline-block;
        width: 16px;
        height: 16px;
        background-image: url(${Icon});
        background-size: 16px 7038px;
        background-position: 0 -6138px;
        filter: grayscale(1);
      }
    }
  }
`;

export const AvatarBlock = styled.p`
  width: 32px;
  height: 32px;
  border-radius: 3px;
  background-image: ${`url(${DefaultAvatar})`};
`;

export const Lshape = styled.div`
  width: 10px;
  height: 10px;
  border-bottom: 0.8px solid #959798;
  border-left: 0.8px solid #959798;
`;

export default function Header() {
  const isLogin = useSelector((state) => state.isLogin);
  const [isSearch, setIsSearch] = useState(false);
  const [togglePopUp, setTogglePopUp] = useState(false);
  const [userInfo, setUserInfo] = useState();

  return (
    <>
      <Gnb>
        <div>
          <MobileMenuBtn>
            <span></span>
          </MobileMenuBtn>
          <Link to="/">
            <Logo>
              <p></p>
            </Logo>
          </Link>
          <MenuNav>
            {isLogin ? (
              <p className="disabled">Products</p>
            ) : (
              <>
                <p className="disabled">About</p>
                <p className="disabled">Products</p>
                <p className="disabled">For Teams</p>
              </>
            )}
          </MenuNav>
          <LoginNav>
            <MobileSearchButton className="prevent-searchbar">
              <svg
                className="prevent-searchbar"
                aria-hidden="true"
                width="18"
                height="18"
                viewBox="0 0 18 18"
              >
                <path
                  className="prevent-searchbar"
                  d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"
                ></path>
              </svg>
            </MobileSearchButton>
            <SearchIcon visible={isSearch}>
              <svg
                className="prevent-searchbar"
                aria-hidden="true"
                width="17"
                height="17"
                viewBox="0 0 18 18"
              >
                <path d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z"></path>
              </svg>
            </SearchIcon>
            <SearchGroup>
              <Search
                placeholder="Search..."
                className="prevent-searchbar"
                visible={isSearch}
              ></Search>
              <SearchDropDown>
                <div>
                  <ul>
                    <li>
                      [tag] <span>search within a tag</span>
                    </li>
                    <li>
                      user:1234 <span>search by author</span>
                    </li>
                    <li>
                      "words here" <span>axact phrase</span>
                    </li>
                    <li>
                      collective:"Name" <span>collecticve content</span>
                    </li>
                  </ul>
                  <ul>
                    <li>
                      answers:0 <span>unanswered questions</span>
                    </li>
                    <li>
                      score:3 <span>posts with a 3+ score</span>
                    </li>
                    <li>
                      is:question <span>type of post</span>
                    </li>
                    <li>
                      isaccepted:yes <span>search within status</span>
                    </li>
                  </ul>
                </div>
                <div>
                  <p>Ask a question</p>
                  <small>search help</small>
                </div>
              </SearchDropDown>
              <SearchArrow></SearchArrow>
            </SearchGroup>
            {isLogin ? (
              <ul>
                <MyPageBtn>
                  <Link to="/mypage">
                    <HeaderAvatar img={""}></HeaderAvatar>
                  </Link>
                </MyPageBtn>
                <li className="disabled">
                  <svg width="18" height="16" viewBox="0 0 20 18">
                    <path d="M4.63 1h10.56a2 2 0 0 1 1.94 1.35L20 10.79V15a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-4.21l2.78-8.44c.25-.8 1-1.36 1.85-1.35Zm8.28 12 2-2h2.95l-2.44-7.32a1 1 0 0 0-.95-.68H5.35a1 1 0 0 0-.95.68L1.96 11h2.95l2 2h6Z"></path>
                  </svg>
                </li>
                <li className="green disabled">
                  <svg width="17" height="17" viewBox="0 0 18 18">
                    <path d="M15 2V1H3v1H0v4c0 1.6 1.4 3 3 3v1c.4 1.5 3 2.6 5 3v2H5s-1 1.5-1 2h10c0-.4-1-2-1-2h-3v-2c2-.4 4.6-1.5 5-3V9c1.6-.2 3-1.4 3-3V2h-3ZM3 7c-.5 0-1-.5-1-1V4h1v3Zm8.4 2.5L9 8 6.6 9.4l1-2.7L5 5h3l1-2.7L10 5h2.8l-2.3 1.8 1 2.7h-.1ZM16 6c0 .5-.5 1-1 1V4h1v2Z"></path>
                  </svg>
                </li>
                <li className="disabled">
                  <svg width="16" height="16" viewBox="0 0 18 18">
                    <path d="M9 1C4.64 1 1 4.64 1 9c0 4.36 3.64 8 8 8 4.36 0 8-3.64 8-8 0-4.36-3.64-8-8-8Zm.81 12.13c-.02.71-.55 1.15-1.24 1.13-.66-.02-1.17-.49-1.15-1.2.02-.72.56-1.18 1.22-1.16.7.03 1.2.51 1.17 1.23ZM11.77 8c-.59.66-1.78 1.09-2.05 1.97a4 4 0 0 0-.09.75c0 .05-.03.16-.18.16H7.88c-.16 0-.18-.1-.18-.15.06-1.35.66-2.2 1.83-2.88.39-.29.7-.75.7-1.24.01-1.24-1.64-1.82-2.35-.72-.21.33-.18.73-.18 1.1H5.75c0-1.97 1.03-3.26 3.03-3.26 1.75 0 3.47.87 3.47 2.83 0 .57-.2 1.05-.48 1.44Z"></path>
                  </svg>
                </li>
                <li
                  className="popup-btn prevent-popup"
                  onClick={() => {
                    setTogglePopUp(!togglePopUp);
                  }}
                >
                  <span>
                    <svg
                      aria-hidden="true"
                      width="18"
                      height="18"
                      viewBox="0 0 18 18"
                    >
                      <path d="M15 1H3a2 2 0 0 0-2 2v2h16V3a2 2 0 0 0-2-2ZM1 13c0 1.1.9 2 2 2h8v3l3-3h1a2 2 0 0 0 2-2v-2H1v2Zm16-7H1v4h16V6Z"></path>
                    </svg>
                  </span>

                  {togglePopUp ? (
                    <LogoutPop>
                      <header>
                        <p>CURRENT COMMUNITY</p>
                        <svg
                          onClick={() => {
                            setTogglePopUp(!togglePopUp);
                          }}
                          width="18"
                          height="18"
                          viewBox="0 0 18 18"
                        >
                          <path d="M15 4.41 13.59 3 9 7.59 4.41 3 3 4.41 7.59 9 3 13.59 4.41 15 9 10.41 13.59 15 15 13.59 10.41 9 15 4.41Z"></path>
                        </svg>
                      </header>
                      <MenuRows>
                        <Row>
                          <div>
                            <AvatarBlock></AvatarBlock>
                            {/* <p>
                              {userInfo.nickname
                                ? userInfo.nickname
                                : undefined}
                            </p> */}
                          </div>
                          <div>
                            <span>
                              <Link to="/logout">logout</Link>
                            </span>
                          </div>
                        </Row>
                        <Row className="second">
                          <div>
                            <span></span>Stack Overflow
                          </div>
                          <div>
                            <span>help</span>
                            <span>chat</span>
                          </div>
                        </Row>
                        <Row className="third">
                          <div>
                            <div className="Licon">
                              <Lshape></Lshape>
                            </div>
                            <span className="icon"></span>Meta Stack Overflow
                          </div>
                        </Row>
                      </MenuRows>
                    </LogoutPop>
                  ) : (
                    ""
                  )}
                </li>
              </ul>
            ) : (
              <>
                <Link to="/login">
                  <Button sky>Log in</Button>
                </Link>
                <Link to="/signup">
                  <Button>Sign up</Button>
                </Link>
              </>
            )}
          </LoginNav>
        </div>
      </Gnb>
    </>
  );
}
